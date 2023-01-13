public class BinarySearchTree extends BinaryTree { // 二元搜尋樹(繼承二元樹)
    protected Node root = null; // 根節點
    boolean empty = true;

    public void add(int data) { // 新增節點
        Node current = null, prev = null;

        if (empty) {
            root = new Node(data);
            empty = false;
        } else {
            current = root;

            do {
                prev = current;

                if (data < current.data) {
                    current = current.Lnode;
                } else {
                    current = current.Rnode;
                }
            } while (current != null);

            if (data < prev.data) {
                prev.Lnode = new Node(data);
            } else {
                prev.Rnode = new Node(data);
            }
        }
    }

    public Node search(int target) { // 搜尋節點
        Node node = root;

        try {
            do {
                if (target < node.data) {
                    node = node.Lnode;
                } else if (target > node.data) {
                    node = node.Rnode;
                } else {
                    return node;
                }
            } while (node != null);
        } catch (NullPointerException e) {
            System.out.println("No such element!!");
        }

        return null;
    }

    public Node parentOf(int target) { // 取得父節點
        Node current = root, parent = null;

        do {
            Node temp = current;

            if (target < current.data) {
                current = current.Lnode;
            } else if (target > current.data) {
                current = current.Rnode;
            } else if (target == current.data) {
                return parent;
            }

            parent = temp;
        } while (current != null);

        return null;
    }

    public Node parentOf(Node node) { // 取得父節點
        return parentOf(node.data);
    }

    public void del(int data) { // 刪除節點
        Node del = search(data), parent = parentOf(data);

        if (del.Rnode == null && del.Lnode == null) {
            if (parent.Lnode == del) {
                parent.Lnode = null;
            } else {
                parent.Rnode = null;
            }
        } else if (del.Rnode != null && del.Lnode != null) {
            Node min = del.Rnode;

            while (min.Lnode != null) {
                min = min.Lnode;
            }

            if (parentOf(min).Lnode == min) {
                parentOf(min).Lnode = null;
            } else {
                del.Rnode = min.Rnode;
            }
            del.data = min.data;
        } else {
            if (parentOf(del).Lnode == del) {
                if (del.Lnode != null) {
                    parentOf(del).Lnode = del.Lnode;
                } else {
                    parentOf(del).Lnode = del.Rnode;
                }
            } else {
                if (del.Lnode != null) {
                    parentOf(del).Rnode = del.Lnode;
                } else {
                    parentOf(del).Rnode = del.Rnode;
                }
            }
        }

    }

    public Node getRoot() { // 取得根節點
        return root;
    }
}
