package ICTProject.CistPortal.Service;

import ICTProject.CistPortal.Repository.IAuthUserRepository;
import ICTProject.CistPortal.bean.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public boolean registerUser(List<String> lines) {
        lines.removeIf(String::isEmpty);

        for (var line : lines) {
            var split = line.split(",");
            var userId = split[0];
            if (authUserRepository.exists(userId)) {
                return false;
            }
        }

        for (var line : lines) {
            var split = line.split(",");
            var userId = split[0];
            var lastName = split[1];
            var firstName = split[2];
            var grade = split[3];
            var roleName = split[4];
            var role = convRoleId(roleName);
            var userPass = split[5];
            authUserRepository.insert(userId,lastName,firstName,grade,role,userPass);
        }
        return true;
    }

    @Override
    public UserAccount signInUser(String userId, String userPass) {
        UserAccount result = authUserRepository.signIn(userId,userPass);
        return result;
    }
}
