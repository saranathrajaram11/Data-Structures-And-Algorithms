import java.util.*;
import java.io.*;


class node{
int data;
node left,right,parent;

node(int x)
{
this.data=x;
left=right=parent=null;
}

}// end of node class datatype


class BinarySearchTree{

node root;

BinarySearchTree()
{
rooot=null;

}

void insert(int x)
{
node rd=root;
node parent =null;
if (rd==null)
rd=x;
while(rd!=null)
{
p=rd;
if(rd.data<x)
rd=rd.right;
else
rd=rd.left;
}
rd=new node(int x)
rd.parent=p;

}