package ICTProject.CistPortal.service;

import ICTProject.CistPortal.bean.ChoseTarget;
import ICTProject.CistPortal.bean.UserIdCheckBox;

import java.util.List;

public interface ITargetCheckService {
    public List<UserIdCheckBox> getUserIdList(long messageId);
}
