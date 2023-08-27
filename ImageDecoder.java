package com.example.javadigitalsteg;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.util.Pair;
import java.util.stream.IntStream;

public class ImageDecoder implements Decoder{

    @Override
    public String decode(Image image) {
        int breadth=(int)image.getWidth();
        int length=(int)image.getHeight();

        PixelReader reader=image.getPixelReader();

        boolean bits[] =new boolean[breadth*length];
        IntStream.range(0, breadth*length)
                .mapToObj(i->new Pair<>(i,reader.getArgb(i%breadth,i/breadth)))
                .forEach(pair->{
                    String binary=Integer.toBinaryString(pair.getValue());
                    bits[pair.getKey()]= binary.charAt(binary.length()-1)=='1';
                });
        //decode length
        int len=0;
        for(int i=0;i<32;i++)
        {
            if(bits[i])
            {
                len |=(1<<(31-i));

            }
        }
        byte [] finalval = new byte [len];
        for(int i=0;i<len;i++) {
            for (int j = 0; j < 8; j++) {
                if (bits[32 + i * 8 + j]) {
                    finalval[i] |= (1 << (7 - j));
                }
            }
        }
        return new String(finalval);
    }
}

