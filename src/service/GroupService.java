package service;

import models.Group;

import java.util.List;
import java.util.Set;

public interface GroupService {

    String addGroup(Group group);

    Group getGroupByName(String name);

    Group updateGroupName(String groupName, String newName);

    Set<Group> getAllGroups();

    String deleteGroup(String groupName);



}