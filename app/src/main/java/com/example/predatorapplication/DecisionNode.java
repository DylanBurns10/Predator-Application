package com.example.predatorapplication;

public class DecisionNode {

    int nodeID;
    int option1ID;
    int option2ID;
    int option3ID;
    String description;
    String question;
    DecisionNode option1Node;
    DecisionNode option2Node;
    DecisionNode option3Node;

    DecisionNode linkedNode;


    public DecisionNode() {
    }

    public DecisionNode getLinkedNode() {return linkedNode;}
    public void setLinkedNode(DecisionNode linkedNode) {this.linkedNode = linkedNode;}

    public int getNodeID() {return nodeID;}
    public void setNodeID(int nodeID) {this.nodeID = nodeID;}
    public int getOption1ID() {return option1ID;}
    public void setOption1ID(int option1ID) {this.option1ID = option1ID;}
    public int getOption2ID() {return option2ID;}
    public void setOption2ID(int option2ID) {this.option2ID = option2ID;}


    public int getOption3ID() {return option3ID;}
    public void setOption3ID(int option3ID) {this.option3ID = option3ID;}


    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description; }
    public String getQuestion() {return question;}
    public void setQuestion(String question) {this.question = question;}
    public DecisionNode getOption1Node() {return option1Node;}
    public void setOption1Node(DecisionNode option1Node) {this.option1Node = option1Node;}
    public DecisionNode getOption2Node() {return option2Node;}
    public void setOption2Node(DecisionNode option2Node) {this.option2Node = option2Node;}


    public DecisionNode getOption3Node() {return option3Node;}
    public void setOption3Node(DecisionNode option3Node) {this.option3Node = option3Node;}




}
