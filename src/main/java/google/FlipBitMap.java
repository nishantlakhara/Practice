package google;

public class FlipBitMap {
    public void flipBitmap(byte[] bitmap, int width, int height) {
        //width - 16 -> 2
        //height - 3
        int group = width/8;
        int k = 0;
        for(int i=0; i<height; i++) {
            byte[] bitGroup = new byte[group];
            for(int j=0; j<group; j++) {
                bitGroup[j] = bitmap[k];
                k++;
            }
            //Process the bitgroup and reverse it.
            flipBitGroup(bitGroup, bitmap, k);
        }
    }

    private void flipBitGroup(byte[] bitGroup, byte[] bitmap, int endIndex) {
        for(int i=0; i<bitGroup.length; i++) {
            bitmap[endIndex] = flipByte(bitGroup[i]);
            endIndex--;
        }
    }

    private byte flipByte(byte x) {
        byte b = 0;
        while (x != 0)
        {
            b <<= 1;
            b |= ( x & 1);
            x >>= 1;
        }
        return b;
    }

//Monochrome - Black / white

//16 bit
//
//            width = multiple of 8,16,24 -> 1,2,3
//    height = any.
//
//            bitmap[0] = 5 {00000101} -> {10100000}
//    bitmap[1] = 6 {00000110} -> {01100000}
//    bitmap[2] = 7 {00000111} -> {11100000}
//
//    {00000101,00000110} -> {01100000,10100000}
//    {1,2,3} -> {flip(3),flip(2),flip(1)}











}
