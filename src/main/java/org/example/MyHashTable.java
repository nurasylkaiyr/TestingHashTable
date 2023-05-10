package org.example;

public class MyHashTable<K, V> {
    private class HashNode<K, V>{
        private K key; //key for the hash table entry
        private V value; //value associated with the key
        private HashNode<K, V> next; //reference to the next HashNode
        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }
    private HashNode<K, V>[] chainArray;
    private int M = 11; //size of the hash table, which is set to 11 by default
    private int size; //the number of key-value pairs in the hash table
    public MyHashTable(){
        //the default constructor with the default size of 11
        chainArray = new HashNode[M];
    }
    public MyHashTable(int M){
        //the constructor takes an integer and sets M to the give value
        this.M = M;
        chainArray = new HashNode[M];
    }
    private int hash(K key){
        //compute the hash code for a given key and return corresponding index
        int hashCode = key.hashCode();
        int index = Math.abs(hashCode) % M;
        return index;
    }

    //adds a new key-value pair or updates the value associated with an existing key
    public void put(K key, V value){
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];

        //Check if the key already exists
        while(head != null){
            if(head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        //Create a new HashNode and add it to the front of the linked list
        HashNode<K, V> newNode = new HashNode<K, V>(key, value);
        newNode.next = chainArray[index];
        chainArray[index] = newNode;
        size++;
    }

    //retrieve the value associated with a given key in the hash table
    public V get(K key){
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];

        //If the key is found, the method returns the associated value
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

    // remove a key-value pair from the hash table
    public V remove(K key){
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];
        HashNode<K, V> prev = null;

        //If the key is found, the associated value is removed from the linked list and returned,
        // and the size of the hash table is decreased by 1
        while(head != null) {
            if (head.key.equals(key)) {
                if (prev == null) {
                    chainArray[index] = head.next;
                }
                else{
                    prev.next = head.next;
                }
                size--;
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }
    public boolean contains(V value){

    }
    public K getKey(V value){

    }

}
