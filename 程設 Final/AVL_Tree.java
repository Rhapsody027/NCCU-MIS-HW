public class AVL_Tree extends BinarySearchTree { // AVL樹(繼承二元搜尋樹)
    private String info = ""; // 程式執行資訊(最後輸出)

    public int height(Node node) { // 計算節點高度
        if (node != null) {
            if (node.Lnode == null && node.Rnode == null) {
                return 0;
            } else {
                return 1 + (height(node.Lnode) > height(node.Rnode) ? height(node.Lnode)
                        : height(node.Rnode));
            }
        }

        return -1;
    }

    public void updateBF(Node node) { // 更新平衡因子
        if (node != null) {
            node.bf = height(node.Lnode) - height(node.Rnode);
            updateBF(parentOf(node));
        }
    }

    public Node getPivot(Node start) { // 取得平衡因子大於1，需旋轉之軸心節點
        Node current = root, pivot = null;
        updateBF(start);

        while (current != null) {

            if (current.bf > 1 || current.bf < -1) {
                pivot = current;
            }

            // BF = 左高度-右高度
            if (current.bf > 0) {
                current = current.Lnode;
            } else if (current.bf < 0) {
                current = current.Rnode;
            } else {
                current = current.Lnode;
            }
        }

        return pivot;
    }

    public void Right(Node pivot) { // 右旋轉
        Node move = pivot.Lnode;

        pivot.Lnode = move.Rnode;
        move.Rnode = pivot;

        if (pivot == root) {
            root = move;
        } else {
            if (parentOf(pivot).Lnode.data == pivot.data) {
                parentOf(pivot).Lnode = move;
            } else {
                parentOf(pivot).Rnode = move;
            }
        }

        addInfo("Right", pivot.data, move.data);
    }

    public void Left(Node pivot) { // 左旋轉
        Node move = pivot.Rnode;

        pivot.Rnode = move.Lnode;
        move.Lnode = pivot;

        if (pivot == root) {
            root = move;
        } else {
            if (parentOf(pivot).Lnode.data == pivot.data) {
                parentOf(pivot).Lnode = move;
            } else {
                parentOf(pivot).Rnode = move;
            }
        }

        addInfo("Left", pivot.data, move.data);
    }

    public void Left_Right(Node pivot) { // 左右旋轉
        Node childPivot = pivot.Lnode;

        Left(childPivot);
        Right(pivot);
    }

    public void Right_Left(Node pivot) { // 右左旋轉
        Node childPivot = pivot.Rnode;

        Right(childPivot);
        Left(pivot);
    }

    public void addRotate(Node pivot, int newData) { // 新增節點後檢查旋轉
        if (pivot != null) {
            addInfo("Rotate!\n");

            if (pivot.bf > 1) {
                if (pivot.Lnode.data <= newData) {
                    addInfo("\n(LR Rotate)");
                    Left_Right(pivot);
                } else {
                    Right(pivot);
                }
            } else if (pivot.bf < -1) {
                if (pivot.Rnode.data > newData) {
                    addInfo("\n(RL Rotate)");
                    Right_Left(pivot);
                } else {
                    Left(pivot);
                }
            }
        }
    }

    public void delRotate(Node pivot, int newData) { // 刪除節點後檢查旋轉
        if (pivot != null) {
            addInfo("\nRotate!\n");

            if (pivot.bf > 1) {
                Right(pivot);
            } else if (pivot.bf < -1) {
                Left(pivot);
            }
        }
    }

    public void add(int data) { // 新增節點
        super.add(data);
        addInfo("add " + data + "\n");
        addRotate(getPivot(search(data)), data);
    }

    public void del(int data) { // 刪除節點
        Node search = search(data), start = null;

        if (search != null) {
            start = parentOf(search(data));
            super.del(data);
            addInfo("del " + data + "\n");
            delRotate(getPivot(start), data);
        }
    }

    public void addInfo(String str) { // 新增執行資訊
        this.info += str;
    }

    public void addInfo(String mode, int pivot, int move) { // 新增執行資訊
        info += ("\n" + mode + " Rotate:\n");
        info += ("  pivot(down) data: " + pivot + "\n");
        info += ("  move(up) data: " + move + "\n\n");
    }

    public String getInfo() { // 取得執行資訊
        return info;
    }
}
