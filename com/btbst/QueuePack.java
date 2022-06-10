package com.btbst;

/**
 * This object is required to maintain relationship between level & nodes.
 * This is kind of Adapter object
 */
public class QueuePack {

    public int level;
    public TreeNode tNode;

    public QueuePack(int level, TreeNode tNode) {
        this.level = level;
        this.tNode = tNode;
    }
}