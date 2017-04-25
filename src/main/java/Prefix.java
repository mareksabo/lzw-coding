/**
 * @author Marek Sabo
 */
class Prefix {

    private int prefixLength;
    private String entryWord;

    Prefix(int prefixLength, String entryWord) {
        this.prefixLength = prefixLength;
        this.entryWord = entryWord;
    }

    String getPrefixString() {
        return entryWord.substring(0, prefixLength);
    }

    int getPrefixLength() {
        return prefixLength;
    }

    Prefix getLongerPrefix(Prefix another) {
        if (prefixLength >= another.prefixLength) {
            return this;
        } else {
            return another;
        }
    }

    static Prefix findPrefix(String text, String entryWord) {
        char[] textArray = text.toCharArray();
        char[] entryArray = entryWord.toCharArray();
        int currentPrefix;
        for(currentPrefix = 0; currentPrefix < Math.min(entryArray.length, textArray.length); currentPrefix++) {
            if (entryArray[currentPrefix] != textArray[currentPrefix]) {
                break;
            }
        }
        return new Prefix(currentPrefix, entryWord);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Prefix prefix = (Prefix) o;

        return prefixLength == prefix.prefixLength && (entryWord != null ? entryWord.equals(prefix.entryWord) : prefix.entryWord == null);
    }

    @Override
    public int hashCode() {
        int result = prefixLength;
        result = 31 * result + (entryWord != null ? entryWord.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Prefix{" +
                "prefixLength=" + prefixLength +
                ", entryWord='" + entryWord + '\'' +
                '}';
    }
}
