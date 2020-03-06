const BinarySearchTree = function() {
    rootNode = null,

    Node = function(key, leftChild, rightChild) {
        return {
            key: key,
            leftChild: leftChild,
            rightChild: rightChild
        };
    },

    insertNode = (nodeToInsert) => {
        if (rootNode === null) {
            rootNode = nodeToInsert;
            return;
        }

        let focusNode = rootNode;

        while (true) {
            if (nodeToInsert.key < focusNode.key) {
                if (focusNode.leftChild === null) {
                    focusNode.leftChild = nodeToInsert;
                    break;
                }
            } else {
                if (focusNode.rightChild === null) {
                    focusNode.rightChild = nodeToInsert;
                    break;
                }
            }
        }
    },

    inOrderTravseral = (focusNode) => {
        if (focusNode !== null) {
            inOrderTravseral(focusNode.leftChild);

            console.log(focusNode.key);

            inOrderTravseral(focusNode.rightChild);
        }
    };

    return {
        insert: (key) => {
            return insertNode(new Node(key, null, null));
        },

        inOrder: () => {
            return inOrderTravseral(rootNode);
        }
    };
};

let tree = new BinarySearchTree();
tree.insert(3);
tree.insert(2);
tree.insert(4);
tree.inOrder();
