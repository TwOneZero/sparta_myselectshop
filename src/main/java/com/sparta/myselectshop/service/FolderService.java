package com.sparta.myselectshop.service;


import com.sparta.myselectshop.dto.FolderResponseDto;
import com.sparta.myselectshop.entity.Folder;
import com.sparta.myselectshop.entity.User;
import com.sparta.myselectshop.repository.FolderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FolderService {

    private final FolderRepository folderRepository;

    public void addFolders(List<String> folderNames, User user) {
        List<Folder> existFolderList = folderRepository.findAllByUserAndNameIn(user, folderNames);

        var newFolders = folderNames.stream()
                .map(name -> {
                    if (!existFolderList.stream().map(Folder::getName).toList().contains(name)) {
                        return new Folder(name, user);
                    }else {
                        throw new IllegalArgumentException("중복된 폴더명을 제거해주세요! 폴더명: " + name);
                    }
                }).collect(Collectors.toList());

        folderRepository.saveAll(newFolders);

    }

    public List<FolderResponseDto> getFolders(User user) {
        List<Folder> folderList = folderRepository.findAllByUser(user);

        return folderList.stream().map(FolderResponseDto::new).collect(Collectors.toList());
    }
}
