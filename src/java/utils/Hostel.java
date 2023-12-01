package utils;

public class Hostel {
    private char hostelBlock;
    private int totalRooms, roomsOccupied;
    
    public Hostel(char hostelBlock, int totalRooms, int roomsOccupied) {
        this.hostelBlock = hostelBlock;
        this.totalRooms = totalRooms;
        this.roomsOccupied = roomsOccupied;
    }
    
    public char getHostelBlock() {
        return this.hostelBlock;
    }
    
    public int getTotalRooms() {
        return this.totalRooms;
    }
    
    public int getRoomsOccupied() {
        return this.roomsOccupied;
    }
    
    public void setHostelBlock(char hostelBlock) {
        this.hostelBlock = hostelBlock;
    }
    
    public void setTotalRooms(int totalRooms) {
        this.totalRooms = totalRooms;
    }
    
    public void setRoomsOccupied(int roomsOccupied) {
        this.roomsOccupied = roomsOccupied;
    }
}
