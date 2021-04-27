/*
 * package com.spring.oauth;
 * 
 * import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
 * import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
 * import
 * org.springframework.security.oauth2.core.OAuth2AuthenticationException;
 * import org.springframework.security.oauth2.core.user.OAuth2User; import
 * org.springframework.stereotype.Service;
 * 
 * import com.spring.domain.UserVO; import com.spring.provider.OAuth2UserInfo;
 * import com.spring.repository.AccountRepository; import
 * com.spring.security.AccountDetails;
 * 
 * @Service public class PrincipalOauth2UserService extends
 * DefaultOAuth2UserService {
 * 
 * @Autowired private AccountRepository AcReposit;
 * 
 * @Override public OAuth2User loadUser(OAuth2UserRequest userRequest) throws
 * OAuth2AuthenticationException{
 * 
 * OAuth2User oauth2user = super.loadUser(userRequest);
 * 
 * //code를 통해 구성한 정보
 * System.out.println("userRequest clientRegistration : "+userRequest.
 * getClientRegistration()); //token을 통해 응답받은 회원정보
 * System.out.println("oauth2user :" +oauth2user);
 * 
 * return processOAuth2User(userRequest, oauth2user); }
 * 
 * private OAuth2User processOAuth2User(OAuth2UserRequest userRequest,
 * OAuth2User oauth2user) {
 * 
 * OAuth2UserInfo oAuth2UserInfo = null;
 * 
 * if
 * (userRequest.getClientRegistration().getRegistrationId().equals("facebook"))
 * { System.out.println("페이스북 로그인 요청~~"); oAuth2UserInfo = new
 * FaceBookUserInfo(oauth2user.getAttributes()); }
 * 
 * Optional<UserVO> userOptional =
 * AcReposit.findByProviderAndProviderId(oAuth2UserInfo.getProvider(),
 * oAuth2UserInfo.getProviderId());
 * 
 * UserVO user; if (userOptional.isPresent()) { user = userOptional.get(); //
 * user가 존재하면 update 해주기 user.setEmail(oAuth2UserInfo.getEmail());
 * AcReposit.save(user); } else { // user의 패스워드가 null이기 때문에 OAuth 유저는 일반적인 로그인을
 * 할 수 없음. user = UserVO.builder() .username(oAuth2UserInfo.getProvider() + "_"
 * + oAuth2UserInfo.getProviderId()) .email(oAuth2UserInfo.getEmail())
 * .provider(oAuth2UserInfo.getProvider())
 * .providerId(oAuth2UserInfo.getProviderId()) .build(); AcReposit.save(user); }
 * 
 * return new AccountDetails(user, oauth2user.getAttributes()); } }
 * 
 */