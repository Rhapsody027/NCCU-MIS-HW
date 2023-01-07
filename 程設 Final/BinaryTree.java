public class BinaryTree { // 二元樹
    class Node { // 內部類別 二元樹節點
        Node Lnode = null, Rnode = null; // 左、右節點
        int data, bf; // 節點資料、平衡因子

        Node(int data) {
            this.data = data;
        }
    }

    public void preOrder(Node root) { // 前序走訪
        if (root != null) {
            print(root);
            preOrder(root.Lnode);
            preOrder(root.Rnode);
        }
    }

    public void inOrder(Node root) { // 中序走訪
        if (root != null) {
            inOrder(root.Lnode);
            print(root);
            inOrder(root.Rnode);
        }
    }

    public void postOrder(Node root) { // 後序走訪
        if (root != null) {
            postOrder(root.Lnode);
            postOrder(root.Rnode);
            print(root);
        }
    }

    public void print(Node node) { // 印出節點資料
        System.out.print(node.data + " ");
    }
}
