class node{
int data;
node left , right, parent;

node(int data)
{
this.data=data;
left=right=parent=null;
}

}

class splaytree{
node root;
splaytree()
{
root=null;
}
void insert(int data){
node p=null;
node z=root;
while(z!=null){
p=z;
if(z.data<data)
z=z.right;
else
z=z.left;
}
z=new node(data);
z.parent=p;
if(p==null)
root=z;
else{
if(p.data<z.data)
p.right=z;
else
p.left=z;
}
splay(z);
}
void splay(node z){
while(z.parent!=null){
if(z.parent.parent==null){
if(z.parent.left==z)
rightrotate(z.parent);
else 
leftrotate(z.parent);
}
else{
if(z.parent.left==z && z.parent==z.parent.parent.left){
rightrotate(z.parent.parent);
rightrotate(z.parent);
}
else if(z.parent.right==z && z.parent==z.parent.parent.right){
leftrotate(z.parent.parent);
leftrotate(z.parent);
}
else if(z==z.parent.left && z.parent.parent.right==z.parent)
{
rightrotate(z.parent);
leftrotate(z.parent);
}
else{
leftrotate(z.parent);
rightrotate(z.parent);
}
}
}
}
public void leftrotate(node x){
node y=x.right;
if(y!=null)
y.left=x.right;
if(y.left!=null)
y.left.parent=x;
x.parent=y.parent;

if(x.parent==null)
root=y;
else if(x.parent.right==x)
x.parent.right=y;
else
x.parent.left=y;
y.left=x;
x.parent=y;
}
public void rightrotate(node x)
{
node y=x.left;
if(y!=null)
y.right=x.left;
if(y.right!=null)
y.right.parent=x;
x.parent=y.parent;
if(x.parent==null)
{
root=y;
}

else if(x.parent.left==x)
{
x.parent.left=y;
}
else {
x.parent.right=y;
}

y.right=x;
x.parent=y; 
}
node getroot(){
return root;
}
void preorder(node root){
node curr=root;
if(curr!=null){
System.out.println(""+curr.data);
preorder(curr.left);
preorder(curr.right);
}
}
public static void main(String args[]){
splaytree s=new splaytree();
s.insert(10);
s.insert(20);
s.insert(30);
s.insert(40);
s.preorder(s.getroot());
}
}
