public class Palindrome {
    public static Deque<Character> wordToDeque(String word){
        ArrayDeque<Character> d =  new ArrayDeque<>();
        for (int i = 0; i < word.length(); i += 1) {
            d.addLast(word.charAt(i));
        }
        return d;
    }
    public static boolean isPalindrome(String word){
        if (word.length() > 1) {
            for (int i = 0; i < Math.floor(word.length()/2); i += 1) {
                if (word.charAt(i) != word.charAt(word.length() - 1 - i)) return false;
            }
        }
        return true;
    }
    public static boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() > 1) {
            for (int i = 0; i < Math.floor(word.length()/2); i += 1) {
                if (!cc.equalChars(word.charAt(i),word.charAt(word.length() - 1 -i))) return false;
            }
        }
        return true;

    }
    public static void main(String args[]) {
        Palindrome p = new Palindrome();
        ArrayDeque<Character> d = (ArrayDeque<Character>)(p.wordToDeque("wretopretrer"));
        d.printDeque();;
    }
}
