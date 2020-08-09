//package com.yxr.tmall.commonUtils;
//
//import com.yxr.tmall.entity.User;
//import com.yxr.tmall.service.UserService;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.SimpleAuthenticationInfo;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.session.Session;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.apache.shiro.subject.Subject;
//import org.springframework.beans.factory.annotation.Autowired;
//
///**
// * @author: lijincan
// * @date: 2020年02月26日 13:19
// * @Description: TODO
// */
//public class UserRealm extends AuthorizingRealm {
//
//    @Autowired
//    UserService userService;
//
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        System.out.println("执行了=>授权doGetAuthorizationInfo");
//
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//
//        info.addStringPermission("user:add");
//        //获取当前登录的对象
//        Subject subject = SecurityUtils.getSubject();
//
//      //  User currentUser = (User) subject.getPrincipal();
//      //  info.addStringPermission(currentUser.getPrams());
//
//        return info;
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        System.out.println("执行了=>认证doGetAuthenticationInfo");
//
//
//        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
//
//        //从token中取到用户名再去查用户密码
//        User user = userService.queryUserByname(userToken.getUsername());
//
//        if (user == null) {//没有这个人
//            return null;
//        }
//
//        Subject currentSubject = SecurityUtils.getSubject();
//        Session session = currentSubject.getSession();
//        session.setAttribute("loginUser", user);
//
//        return new SimpleAuthenticationInfo(user, user.getPassword(), "");
//    }
//}
