package service.serviceImpl;

import dao.GroupDao;
import dao.StudentDao;
import dao.daoImpl.GroupDaoImpl;
import dao.daoImpl.StudentDaoImpl;
import models.Group;
import service.GroupService;

import java.util.List;
import java.util.Set;

public class GroupServiceImpl implements GroupService {

    private GroupDao groupDao = new GroupDaoImpl();


    @Override
    public String addGroup(Group group) {
        return groupDao.addGroup(group);
    }

    @Override
    public Group getGroupByName(String name) {
        return groupDao.getGroupByName(name);
    }

    @Override
    public Group updateGroupName(String groupName, String newName) {
        return groupDao.updateGroupName(groupName, newName);
    }


    @Override
    public Set<Group> getAllGroups() {
        return groupDao.getAllGroups();
    }

    @Override
    public String deleteGroup(String groupName) {
        return groupDao.deleteGroup(groupName);
    }


}




