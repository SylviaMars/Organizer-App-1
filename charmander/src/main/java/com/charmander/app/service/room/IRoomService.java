package com.charmander.app.service.room;

import com.charmander.app.model.RoomDto;
import org.springframework.http.ResponseEntity;

import java.util.Locale;
import java.util.Set;

public interface IRoomService {

    ResponseEntity<Set<RoomDto>> findAllByLocale(Locale locale);
}
