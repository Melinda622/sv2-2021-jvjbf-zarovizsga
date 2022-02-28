package sentences;

public class SentenceTransformer {

    public String shortenSentence(String sentence) {
        StringBuilder sb = new StringBuilder();

        if (!isSentenceWithCapitalLetters(sentence)) {
            throw new IllegalArgumentException("Must start with capital letter!");
        }

        if (isSentence(sentence)) {
            String output = "";
            String temp[] = sentence.split(" ");
            if (temp.length >= 5) {
                sb.append(temp[0]).append(" ... ").append(temp[temp.length - 1]);
            } else {
                return sentence;
            }
        } else {
            throw new IllegalArgumentException("Must end with . ! or ?");
        }

        return sb.toString();
    }

    private boolean isSentence(String sentence) {
        return sentence.endsWith("!") || sentence.endsWith(".") || sentence.endsWith("?");
    }

    private boolean isSentenceWithCapitalLetters(String sentence) {
        return sentence.charAt(0) == sentence.toUpperCase().charAt(0);
    }
}
