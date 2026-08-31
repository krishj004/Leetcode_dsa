class LFUCache {
    final int capacity;
    int cachesize;
    int minfreq;
    HashMap<Integer,DLL> cache;
    HashMap<Integer,DoubleLinkedList> freqmap;
    public LFUCache(int capacity) {
        this.capacity=capacity;
        this.cachesize=0;
        this.minfreq=0;
        this.cache=new HashMap<>();
        this.freqmap=new HashMap<>();
    }
    
    public int get(int key) {
        DLL currnode=cache.get(key);
        if(currnode==null)
        return -1;
        int val=currnode.value;
        updatenode(currnode);
        return val;
        
    }
    
    public void put(int key, int value) {
        if(capacity==0) return;
        if(cache.containsKey(key)){
            DLL node=cache.get(key);
            node.value=value;
            updatenode(node);
        }
        else{
            cachesize++;
            if(cachesize>capacity){
                DoubleLinkedList minfreqlist=freqmap.get(minfreq);
                cache.remove(minfreqlist.tail.prev.key);
                minfreqlist.removenode(minfreqlist.tail.prev);
                cachesize--;
            }
            int frequency=1;
            minfreq=1;
            DLL currnode=new DLL(key,value);
            DoubleLinkedList currfreqlist=freqmap.getOrDefault(1,new DoubleLinkedList());
            cache.put(key,currnode);
            currfreqlist.addnode(currnode);
            freqmap.put(1,currfreqlist);
        }
    }
        public void updatenode(DLL currnode){
            int currfreq=currnode.freq;
            DoubleLinkedList currfreqlist=freqmap.get(currfreq);
            currfreqlist.removenode(currnode);
            if(currfreq==minfreq && currfreqlist.size==0){
                minfreq++;

            }
            currnode.freq++;
            DoubleLinkedList freqlist=freqmap.getOrDefault(currnode.freq,new DoubleLinkedList());
            freqlist.addnode(currnode);
            freqmap.put(currnode.freq,freqlist);
        }
    
}
class DLL{
    int key;
    int value;
    int freq;
    DLL next;
    DLL prev;
    public DLL(int key,int val){
        this.key=key;
        this.value=val;
        this.freq=1;
    }
}
class DoubleLinkedList{
    int size;
    DLL head;
    DLL tail;
    public DoubleLinkedList(){
        this.head=new DLL(0,0);
        this.tail=new DLL(0,0);
        head.next=tail;
        tail.prev=head;
    }
    public void addnode(DLL currnode){
        DLL nextnode=head.next;
        currnode.next=nextnode;
        currnode.prev=head;
        head.next=currnode;
        nextnode.prev=currnode;
        size++;
    }
    public void removenode(DLL currnode){
        DLL nextnode=currnode.next;
        DLL prevnode=currnode.prev;
        prevnode.next=nextnode;
        nextnode.prev=prevnode;
        size--;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */