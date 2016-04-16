# Tali - HTTP pinger for web resources

Sometimes you need to check if your web resources are still available and not turned off. So here is little ping master for check availability states of all you want.

All your properties are stored in app-properties.json.

There is no front-end for now, only simple commands:
  - /hello - just because.
  - /properties - check all your properties of Tali
  - /response - check last states of your web resources
 
Back-end:
  - Sping MVC
  - Spring Security
  - jackson
  - slf4j+log4j
  - JUnit