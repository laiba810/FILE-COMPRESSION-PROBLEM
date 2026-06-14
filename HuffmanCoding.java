import java.util.*;
public class HuffmanCoding {
    private HashMap<Character, String> huffmanCodes;
    private HuffmanNode root;
    public HuffmanCoding() {
        huffmanCodes = new HashMap<>();
    }
    public void buildTree(String text) {
        HashMap<Character, Integer> frequencyMap =
                new HashMap<>();
        for (char c : text.toCharArray()) {
            frequencyMap.put(c,
                    frequencyMap.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<HuffmanNode> minHeap =
                new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry :
                frequencyMap.entrySet()) {

            minHeap.add(new HuffmanNode(
                    entry.getKey(),
                    entry.getValue()));
        }
        while (minHeap.size() > 1) {
            HuffmanNode left = minHeap.poll();
            HuffmanNode right = minHeap.poll();
            HuffmanNode parent =
                    new HuffmanNode('\0',
                            left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;
            minHeap.add(parent);
        }
        root = minHeap.poll();
        generateCodes(root, "");
    }
    private void generateCodes(HuffmanNode node,
                               String code) {
        if (node == null)
            return;
        if (node.left == null &&
                node.right == null) {
            huffmanCodes.put(node.character,
                    code.length() > 0 ? code : "0");
        }
        generateCodes(node.left, code + "0");
        generateCodes(node.right, code + "1");
    }
    public String compress(String text) {
        StringBuilder compressed =
                new StringBuilder();
        for (char c : text.toCharArray()) {
            compressed.append(huffmanCodes.get(c));
        }
        return compressed.toString();
    }
    public String decompress(String compressedText) {
        StringBuilder result =
                new StringBuilder();
        HuffmanNode current = root;
        for (char bit :
                compressedText.toCharArray()) {
            if (bit == '0')
                current = current.left;
            else
                current = current.right;
            if (current.left == null &&
                    current.right == null) {
                result.append(current.character);
                current = root;
            }
        }
        return result.toString();
    }
    public void displayCodes() {
        System.out.println("\nHUFFMAN CODES");
        for (Map.Entry<Character, String> entry :
                huffmanCodes.entrySet()) {
            System.out.println(entry.getKey()
                    + " : "
                    + entry.getValue());
        }
    }
}