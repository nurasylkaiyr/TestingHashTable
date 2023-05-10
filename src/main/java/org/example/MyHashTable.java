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
        int hashCode = key.hashCode();
        int index = Math.abs(hashCode) % M;
    }
    public void put(K key, V value){

    }
    public V get(K key){

    }
    public V remove(K key){

    }
    public boolean contains(V value){

    }
    public K getKey(V value){

    }

}
