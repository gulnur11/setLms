package dao.daoImpl;

import dao.GroupDao;
import database.Database;
import models.Group;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupDaoImpl implements GroupDao {

    Database database = new Database();

    @Override
    public String addGroup(Group group) {
        for (Group existingGroup : Database.groups) {
            if (existingGroup.getId().equals(group.getId())) {
                throw new RuntimeException("Мындай " + group.getId() + "чи ID деги группа бар.");
            }
        }
        Database.groups.add(group);
        return group.getId() + "  чи ID деги " + group.getGroupName() + " аттуу группа ийгиликтуу сакталды.";
    }


    @Override
     public Group getGroupByName(String name) {
    for (Group group : Database.groups) {
        if (group.getGroupName() != null && group.getGroupName().equalsIgnoreCase(name)) {
            return group;
        }
    }
    throw new RuntimeException("Мындай группа табылган жок ");
    }



    @Override
public Group updateGroupName(String groupName, String newName) {
    for (Group group : Database.groups) {
        if (group.getGroupName() != null && group.getGroupName().equalsIgnoreCase(groupName)) {
            group.setGroupName(newName);
            return group;
        }
    }
    throw new  RuntimeException("Мындай группа табылган жок ");

}

    @Override
public Set<Group> getAllGroups() {
    return new HashSet<>(Database.groups);
}




    @Override
public String deleteGroup(String groupName) {
    for (Group group : new HashSet<>(Database.groups)) {
        if (groupName.equalsIgnoreCase(group.getGroupName())) {
            Database.groups.remove(group);
            return "Group with name '" + groupName + "' deleted.";
        }
    }
    throw new IllegalStateException("Мындай группа табылган жок ");
}




}
