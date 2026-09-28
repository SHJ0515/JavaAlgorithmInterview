import java.io.*;
import java.util.*;

/*
boj1991 트리 순회
- 이진트리를 입력받아 전, 중, 후위 순회한 결과를 출력
- N개의 노드
- 노드 이름은 A부터 차례대로, A는 루트노드, 자식노드가 없으면 . 으로 표현
 */

public class boj1991 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static Node[] nodes = new Node[26];

    static class Node {
        char value;
        Node lc;
        Node rc;
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char value = st.nextToken().charAt(0);
            char lc = st.nextToken().charAt(0);
            char rc = st.nextToken().charAt(0);

            Node tempNode = getOrCreateNode(value);
            if (lc != '.') {
                tempNode.lc = getOrCreateNode(lc);
            }
            if (rc != '.') {
                tempNode.rc = getOrCreateNode(rc);
            }
        }

        preOrder(nodes[0]);
        System.out.println(sb);
        sb.setLength(0);

        inOrder(nodes[0]);
        System.out.println(sb);
        sb.setLength(0);

        postOrder(nodes[0]);
        System.out.println(sb);
    }

    public static void preOrder(Node node) {
        if (node != null) {
            sb.append(node.value);
            preOrder(node.lc);
            preOrder(node.rc);
        }
    }

    public static void inOrder(Node node) {
        if (node != null) {
            inOrder(node.lc);
            sb.append(node.value);
            inOrder(node.rc);
        }
    }

    public static void postOrder(Node node) {
        if (node != null) {
            postOrder(node.lc);
            postOrder(node.rc);
            sb.append(node.value);
        }
    }

    public static Node getOrCreateNode(char value) {
        int index = value - 'A';

        if (nodes[index] == null) {
            nodes[index] = new Node();
            nodes[index].value = value;
        }
        return nodes[index];
    }
}