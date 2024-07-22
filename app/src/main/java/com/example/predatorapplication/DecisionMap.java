package com.example.predatorapplication;

import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

import static java.lang.Integer.*;

public class DecisionMap {

    DecisionNode head;
    DecisionNode tail;
    Context context;

    public DecisionMap(Context context) throws CustomException{
        this.context = context;
        InputStream is = context.getResources().openRawResource(R.raw.data);
        try (Scanner inFile = new Scanner(is)){
            buildUnorderedList(inFile);
            buildOrderedMap();
        }
    }

    private void append(DecisionNode newNode) {

        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            this.tail.setLinkedNode(null);

            return;
        }

        this.tail.setLinkedNode(newNode);
        this.tail = newNode;
    }

    public void buildUnorderedList(Scanner dataSet) {

        dataSet.useDelimiter(",");
        DecisionNode node ;
        do {
            String line = dataSet.nextLine();
            node = buildNode(line);
            append(node);
        } while (dataSet.hasNext());
        dataSet.close();

    }

    private void buildOrderedMap() {

        if (head == null) {return;}

        DecisionNode nodeLinker = head;

        while (nodeLinker != null) {

            int option1ID = nodeLinker.getOption1ID();
            int option2ID = nodeLinker.getOption2ID();
            int option3ID = nodeLinker.getOption3ID();

            DecisionNode option1Node = nodeFetch(option1ID);
            DecisionNode option2Node = nodeFetch(option2ID);
            DecisionNode option3Node = nodeFetch(option3ID);

            nodeLinker.setOption1Node(option1Node);
            nodeLinker.setOption2Node(option2Node);
            nodeLinker.setOption3Node(option3Node);

            nodeLinker = nodeLinker.getLinkedNode();

        }

        cleanup();

    }

    private void cleanup(){
        if (head == null) {return;}

        DecisionNode currentNode = head;
        DecisionNode nextNode = head.getLinkedNode();

        while (nextNode != null) {

            currentNode.setLinkedNode(null);

            currentNode = nextNode;
            nextNode = currentNode.getLinkedNode();
        }
    }

    private DecisionNode buildNode(String line) {
        String[] stringArray = line.split(",");
        DecisionNode n = new DecisionNode();

        n.setNodeID(parseInt(stringArray[0]));
        n.setOption1ID(parseInt(stringArray[1]));
        n.setOption2ID(parseInt(stringArray[2]));
        n.setOption3ID(parseInt(stringArray[3]));
        n.setDescription(stringArray[4]);
        n.setQuestion(stringArray[5]);

        return n;
    }

    public DecisionNode entryPoint() {
        return head;
    }

    private DecisionNode nodeFetch(int nodeID) {

        DecisionNode nodeLinker = head;

        while (nodeLinker != null) {
            if(nodeLinker.getNodeID() == nodeID){ break ;}
            nodeLinker = nodeLinker.getLinkedNode();
        }

        return nodeLinker;
    }


    private boolean isEmpty() {
        return this.head == null;
    }
}