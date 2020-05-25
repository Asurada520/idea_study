package com.ybzbcq.designpattern.facade;

public class Computer {

    private CPU cpu;
    private Memory memory;
    private Disk disk;

    public Computer() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.disk = new Disk();
    }


    public void startup(){
        System.out.println("Start the computer");
        cpu.startup();
        memory.startup();
        disk.startup();
        System.out.println("Start the computer finished");
    }

    public void shutdown(){
        System.out.println("Shutdown the computer");
        cpu.shutdown();
        memory.shutdown();
        disk.shutdown();
        System.out.println("Closed the computer");
    }
}
