package com.example.Hotel_Management.Controller;

import com.example.Hotel_Management.Model.HotelRoom;
import com.example.Hotel_Management.Model.Type;
import com.example.Hotel_Management.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class RoomController {

    @Autowired
    RoomService roomService;

    //read
    @GetMapping("rooms")
    public Iterable<HotelRoom> getAllRooms()
    {

        return roomService.getAllRooms();
    }


    @PostMapping("room")
    public String addRoom(@RequestBody HotelRoom room)
    {
        return roomService.addRoom(room);
    }
    @PostMapping("rooms")
    public String addRooms(@RequestBody List<HotelRoom> rooms){
        return roomService.addRooms(rooms);
    }
    @GetMapping("rooms/{id}")
    public HotelRoom getRoomsById(@PathVariable long id){
        return roomService.FindRoomById(id);
    }
    @GetMapping("rooms/{id}/exists")
    public boolean isExist(@PathVariable long id) {
        return roomService.isRoomExist(id);
    }
    @GetMapping("rooms/count")
    public long getRoomsCount() {
        return roomService.FindRoomsCount();
    }
    @DeleteMapping("room/{id}")
    public String deleteRoomById(@PathVariable long id) {
        return roomService.deleteRoomById(id);
    }
    @DeleteMapping("rooms")
    public String deleteAllRoom() {
        return roomService.deleteAllRoom();
    }
    @PutMapping("room/{id}/{type}")
    public String updateRoomById(@PathVariable long id,@PathVariable Type type) {
        return roomService.updateRoomById(id,type);
    }
    @GetMapping("rooms/status/{status}")
    public List<HotelRoom> getRoomsByStatus(@PathVariable Boolean status)
    {
        return roomService.getRoomsByStatus(status);
    }
    @GetMapping("rooms/status/{status}/type/{type}")
    public List<HotelRoom> getRoomsByStatusAndType(@PathVariable Boolean status,@PathVariable Type type)
    {
        return roomService.getRoomsByStatusAndType(status,type);
    }
    @GetMapping("rooms/status/{status}/type/{type}/priceRange")
    public List<HotelRoom> getRoomsByStatusAndTypeAndPrice(@PathVariable Boolean status,@PathVariable Type type, @RequestParam Double lLimit, @RequestParam Double uLimit)
    {
        return roomService.getRoomsByStatusAndTypeAndPrice(status,type,lLimit,uLimit);
    }
    @GetMapping("rooms/Type/{roomType}")
    public List<HotelRoom> getRoomsByTypeAndPrice(@PathVariable Type roomtype)
    {
        return roomService.getRoomsByTypeAndPrice(roomtype);
    }

}
