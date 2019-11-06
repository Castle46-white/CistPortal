package ICTProject.CistPortal.repository;

import ICTProject.CistPortal.model.MessageView;

import java.util.List;

public interface IMessageViewRepository {
    public List<MessageView> selectMany();

    public List<MessageView> selectOne(int id);
}


