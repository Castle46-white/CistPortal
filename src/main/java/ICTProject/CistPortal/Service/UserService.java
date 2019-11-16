package ICTProject.CistPortal.Service;

import ICTProject.CistPortal.Repository.IAuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private IAuthUserRepository authUserRepository;

    @Autowired
    public UserService(IAuthUserRepository authUserRepository) {
        this.authUserRepository = authUserRepository;
    }

    @Override
    public int convRoleId(String role) {
        int roleId = authUserRepository.getRoleId(role);
        return roleId;
    }

    @Override
    public void registerUser(String userId,String lastName,String firstName,String grade,int role,String userPass) {
        authUserRepository.insert(userId,lastName,firstName,grade,role,userPass);
    }

    @Override
    public boolean existsUser(String userId,String userPass) {
        String role;
        boolean result = authUserRepository.exists(userId,userPass);
        System.out.println(userId + " , " + userPass + " のユーザ照合結果：" + result);
        return result;
    }
}
