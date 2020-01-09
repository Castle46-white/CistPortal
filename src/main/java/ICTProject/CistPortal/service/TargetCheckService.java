package ICTProject.CistPortal.service;

import ICTProject.CistPortal.bean.ChoseTarget;
import ICTProject.CistPortal.bean.UserIdCheckBox;
import ICTProject.CistPortal.repository.IMessageTargetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TargetCheckService implements ITargetCheckService {

    @Autowired
    IMessageTargetRepository messageTargetRepository;

    @Override
    public List<UserIdCheckBox> getUserIdList(long messageId) {
        List<UserIdCheckBox> list1 = messageTargetRepository.selectUserId();
        for (UserIdCheckBox userIdCheckBox : list1) {
            System.out.println(userIdCheckBox.getId());
        }

        List<ChoseTarget> list2 = messageTargetRepository.choseTarget(messageId);
        for (UserIdCheckBox userIdCheckBox : list1) {
            for (ChoseTarget choseTarget : list2) {
                if (userIdCheckBox.getId().equals(choseTarget.getUserId())) {
                    userIdCheckBox.setTarget(true);
                    break;
                } else {
                    userIdCheckBox.setTarget(false);
                }
            }
        }
        return list1;
    }
}
