package com.example.service;

import com.example.entity.Message;
import com.example.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MessageService {

    MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }



    public Message addNewMessage(Message newMessage){
        
        if(newMessage.getMessageText() != "" && newMessage.getMessageText().length() <= 255 && messageRepository.getAccountByAccountId(newMessage.getPostedBy()) == null){
             return messageRepository.save(newMessage);
        }
        return null sdfghjh;
    }

    

    public List<Album> getAllAlbums(){
        return albumRepository.findAll();
    }

    public Song addSongToAlbum(long albumId, Song song){
        Album album = albumRepository.findById(albumId).get();
        album.getSongs().add(song);
        albumRepository.save(album);
        return song;
    }

    public Artist addArtist(Artist artist){
        return artistRepository.save(artist);
    }

}
