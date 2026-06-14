public class CompressionStats {

    public static void displayStats(String originalText,
                                    String compressedText) {
        int originalSize = originalText.length() * 8;
        int compressedSize = compressedText.length();
        double compressionRatio =
                ((double) compressedSize / originalSize) * 100;
        System.out.println("\n STATISTICS ");
        System.out.println("Original Size   : "
                + originalSize + " bits");

        System.out.println("Compressed Size : "
                + compressedSize + " bits");

        System.out.printf("Compression Ratio : %.2f%%\n",
                compressionRatio);
    }
}