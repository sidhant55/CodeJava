package Data_Structure;

public class Trie {

    static final int Size=26;
    static class TrieNode
    {
        TrieNode[] children =new TrieNode[Size];
        boolean end;

        TrieNode()
        {
            end=false;
            for (int i=0;i<Size;i++)
                children[i]=null;
        }
    };

    static TrieNode root;

    static void insert(String key)
    {
        int level;
        int lenght=key.length();
        int index;

        TrieNode pCrawl=root;
        for (level=0;level<lenght;level++)
        {
            index=key.charAt(level)-'a';
            if (pCrawl.children[index]==null)
                pCrawl.children[index]=new TrieNode();
            pCrawl=pCrawl.children[index];
        }
        pCrawl.end=true;
    }

    static boolean search(String key)
    {
        TrieNode node=root;
        int len=key.length();
        for (int i=0;i<len;i++)
        {
            int index=key.charAt(i)-'a';
            if (node.children[index]==null)
                return false;
            node=node.children[index];
        }
        return (node != null && node.end);
    }

    static boolean deleteKey(String key)
    {
        int len=key.length();
        TrieNode node=root;
        boolean flag=false;
        for (int i=0;i<len;i++)
        {
            int index=key.charAt(i)-'a';
            if (node.children[index]!=null)
                node=node.children[index];
            else
            {
                flag=true;
                break;
            }
        }
        if (flag==false)
            node.end=false;

        return flag;
    }

    public static void main(String args[]) {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "these","a", "there", "answer", "any",
                "by", "bye", "their"};

        String output[] = {"Not present in trie", "Present in trie"};


        root = new TrieNode();

        // Construct trie
        int i;
        for (i = 0; i < keys.length ; i++)
            insert(keys[i]);

        // Search for different keys
        if(search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if(search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

        if(search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);

        if(search("thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);

        deleteKey(keys[0]);

        if(search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        deleteKey(keys[1]);

        if(search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

        if(search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);
    }
}
