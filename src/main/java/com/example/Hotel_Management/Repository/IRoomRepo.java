package com.example.Hotel_Management.Repository;

import com.example.Hotel_Management.Model.HotelRoom;
import com.example.Hotel_Management.Model.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoomRepo extends CrudRepository<HotelRoom,Long> {
    List<HotelRoom> findByRoomStatus(Boolean roomStatus);
    List<HotelRoom> findByRoomStatusAndRoomType(Boolean status, Type type);
    List<HotelRoom> findByRoomStatusAndRoomTypeAndRoomPriceGreaterThanAndRoomPriceLessThan(Boolean status, Type type, Double lLimit, Double uLimit);
    List<HotelRoom> findByRoomTypeOrderByRoomPriceDesc(Type type);
}
