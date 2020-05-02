package com.charmander.app.service.room;

import com.charmander.app.mapper.IRoomMapper;
import com.charmander.app.model.RoomDto;
import com.charmander.app.repository.RoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Service
public class RoomServiceImpl implements IRoomService {

    private RoomRepository roomRepo;
    private IRoomMapper iRoomMapper;

    @Override
    public ResponseEntity<Set<RoomDto>> findAllByLocale(Locale locale) {
        var rooms = roomRepo.findAllByLocale(locale.toLanguageTag());
        return (rooms.isEmpty()) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                                     new ResponseEntity<>(new HashSet<>(iRoomMapper.toDtos(rooms)), HttpStatus.OK);
    }
}
