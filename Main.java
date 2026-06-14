import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println(" FILE COMPRESSION USING HUFFMAN ");
        System.out.print("\nEnter Text: ");
        String text = input.nextLine();
        if (text.isEmpty()) {
            System.out.println("Input cannot be empty.");
            return;
        }
        HuffmanCoding compressor =
                new HuffmanCoding();
        compressor.buildTree(text);
        compressor.displayCodes();
        String compressedText =
                compressor.compress(text);
        String decompressedText =
                compressor.decompress(compressedText);
        System.out.println("\nCompressed Binary:");
        System.out.println(compressedText);
        System.out.println("\nDecompressed Text:");
        System.out.println(decompressedText);
        CompressionStats.displayStats(
                text,
                compressedText);
        System.out.println(
                "\nCompression Completed Successfully.");
    }
}