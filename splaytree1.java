class node{
int data;
node left,right,parent;

node(int data)
{
this.data=data;
left=right=parent=null;
}
}

class splaytree1{
node root;

splaytree1()
{
root=null;
}

void insert(int value)
{
node dup=root;
node p=null;

if(dup==null)
  root=new node(value);
while(dup!=null)
{
p=dup;
if(value<dup.data)
dup=dup.left;

else 
dup=dup.right;   
}
dup=new node(value);
if(p=null)
root=dup;
else if(dup.data<p.data)
p.left=dup;
else
p.right=dup;
splay(dup);


void splay(node d)
{
while(dup.parent!=null)
{
if(dup.parent.parent==null)
{
if(dup==dup.parent.left)
rightrotate(dup.parent)
else 
leftrotate(dup.parent)
}
else {
if(dup==dup.parent.left && dup.parent.parent.left==dup.parent )//zigzig
{
rightrotate(dup.parent.parent);
rightrotate(dup.parent);
}
else if (dup==dup.parent.right && dup.parent==dup.parent.parent.right)
{
  leftroate(dup.parent.parent);
  leftroate(dup.parent);
}
else if(dup==dup.parent.left && dup.parent==dup.parent.right)
{
  rightrotate(dup.parent);          
  rightrotate(dup.parent);          
}
else{
  leftrotate(dup.parent);
  leftrotate(dup.parent);
}
}
}

void leftrotate(node h)
{
  node x;

}

void rightrotate(node h)
}

}
}       //end of the class

