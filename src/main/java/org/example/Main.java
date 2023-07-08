package org.example;
class Node{
    Node Next;
    int Coff;
    int Power;
    Node Pervious;

    public Node(int coff,int Power){
        this.Coff=coff;
        this.Power=Power;
        this.Next=null;
        this.Pervious=Pervious;
    }
}
class DLinkedList{
    Node front;
    public DLinkedList(){
        front=null;
    }
    public void insertDataFront(int coff,int power){
        Node n=new Node(coff,power);
        if(front==null)front=n;
        else{
            n.Next=front;
            front.Pervious=n;
            front=n;
        }
    }
    public void  insertDataBack (int coff,int power){
        Node n=new Node(coff,power);
        if(front==null)front=n;
        else{
            Node p=front;
            while (p.Next!=null){
                p=p.Next;
            }
            p.Next=n;
            n.Pervious=p;

        }
    }
    private int sum=0;
    public int size(){
        Node p1=front;
        while (p1!=null){
            sum++;
            p1=p1.Next;
        }
        return sum;
    }
    public void TestPrint(){
        Node p=front;
        while (p!=null){
            System.out.println("Coff"+" "+p.Coff+" "+"power"+" "+p.Power);
            p=p.Next;
        }
    }
    public void Evaluate(int x){
        int sum=0;
        Node p=front;
        while (p!=null){
            double y=p.Coff*Math.pow(x,p.Power);
            sum+=y;
            p=p.Next;
        }
        System.out.println(sum);
    }
    public boolean powerSearch(int power){
        Node p=front;
        while (p!=null){
            if(p.Power==power) return true;
            p=p.Next;
        }
        return false;
    }


}

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
        DLinkedList l1=new DLinkedList();
        l1.insertDataFront(6,1);
        l1.insertDataFront(-9,0);



//        l1.Evaluate(2);
        DLinkedList l2=new DLinkedList();
        l2.insertDataFront(7,1);
        l2.insertDataFront(2,0);

        DLinkedList d= add2Polynomials(l1,l2);
        DLinkedList d1= Substract(l1,l2);
        DLinkedList d2=MultPly(l1,l2);
        d.TestPrint();
        d1.TestPrint();
        d2.TestPrint();
        d2.Evaluate(2);



    }
    public static DLinkedList add2Polynomials(DLinkedList pol1,DLinkedList pol2) {
        if(pol2.size()!=pol2.size()){
            if(pol1.size()> pol2.size()){
                while (pol1.size()>pol2.size()){pol2.insertDataBack(0,0);}
            }
         else if(pol2.size()> pol1.size()){
                while (pol2.size()>pol1.size()){pol1.insertDataBack(0,0);}
            }
        }

        DLinkedList d1 = new DLinkedList();
        Node p1 = pol1.front;
        Node p2 = pol2.front;

            while (p1 != null && p2 != null) {
                if (p1.Power == p2.Power) {
                    int sum = p1.Coff + p2.Coff;
                    d1.insertDataFront(sum, p1.Power);
                } else if (p1.Power != p2.Power) {
                    //If Power Of Polynomial Greater Than Another
                    if (p1.Power > p2.Power) {d1.insertDataFront(p1.Coff, p1.Power);
                    }

                    if (p2.Power > p1.Power) {
                        d1.insertDataFront(p2.Coff, p2.Power);
                    }

                }
                p1 = p1.Next;
                p2 = p2.Next;
            }
        return d1;
    }

    public static DLinkedList ChangeSign(DLinkedList d1){
        DLinkedList tmp=new DLinkedList();
        Node p1=d1.front;
        while (p1!=null){
            tmp.insertDataBack(-1*p1.Coff, p1.Power);
            p1=p1.Next;
        }
        return tmp;
    }
    public static DLinkedList Substract(DLinkedList d1, DLinkedList d2){
        DLinkedList ChngedSign=ChangeSign(d2);
       DLinkedList s=add2Polynomials(d1,ChngedSign);
        return s;
    }
    public static DLinkedList MultPly(DLinkedList d1,DLinkedList d2){
        DLinkedList tmp=new DLinkedList();
        Node p1=d1.front;
        Node p2=d2.front;
        while(p1!=null) {
            while (p2 != null) {
                tmp.insertDataFront(p1.Coff * p2.Coff, p1.Power + p2.Power);
                p2 = p2.Next;
            }
             p2=d2.front;
            p1=p1.Next;

        }

        return tmp;
    }





}