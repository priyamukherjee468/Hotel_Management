package com.example.Hotel_Management.Service;

import com.example.Hotel_Management.Model.HotelRoom;
import com.example.Hotel_Management.Model.Type;
import com.example.Hotel_Management.Repository.IRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@Service
        public class RoomService {

            @Autowired
            IRoomRepo roomRepo;

            public Iterable<HotelRoom> getAllRooms() {
                return roomRepo.findAll();
            }

            public String addRoom(HotelRoom room) {
                roomRepo.save(room);
                return "added";
            }

    public String addRooms(List<HotelRoom> rooms) {
                roomRepo.saveAll(rooms);
                return "added!!"+rooms;
    }

    public HotelRoom FindRoomById(long id){
        Optional<HotelRoom>optionalHotelRoom=roomRepo.findById(id);
        if(optionalHotelRoom.isEmpty()){
            return null;
        }
        return optionalHotelRoom.get();
    }

    public boolean isRoomExist(long ids) {
                return roomRepo.existsById(ids);
    }

    public long FindRoomsCount() {
                return roomRepo.count();
    }

    public String deleteRoomById(long id) {
        roomRepo.deleteById(id);
        return "room deleted successfully of id "+id;
    }

    public String deleteAllRoom() {
                roomRepo.deleteAll();
                return "deleted";
    }

    public String updateRoomById(long id, Type type) {

            Optional<HotelRoom> myRoomOpt = roomRepo.findById(id);
            HotelRoom myRoom = null;
            if(myRoomOpt.isPresent())
            {
                myRoom = myRoomOpt.get();
            }
            else {
                return "Id not Found!!!";
            }
            myRoom.setRoomType(type);
            roomRepo.save(myRoom);
            return "room type updated";

        }

    public List<HotelRoom> getRoomsByStatus(Boolean status) {
        return roomRepo.findByRoomStatus(status);
    }

    public List<HotelRoom> getRoomsByStatusAndType(Boolean status, Type type) {
                return roomRepo.findByRoomStatusAndRoomType(status,type);
    }

    public List<HotelRoom> getRoomsByStatusAndTypeAndPrice(Boolean status, Type type, Double lLimit, Double uLimit) {
                return roomRepo.findByRoomStatusAndRoomTypeAndRoomPriceGreaterThanAndRoomPriceLessThan(status, type, lLimit, uLimit);
    }

    public List<HotelRoom> getRoomsByTypeAndPrice(Type roomtype) {
                return roomRepo.findByRoomTypeOrderByRoomPriceDesc(roomtype);
    }
}


