#!/bin/bash

echo " ************ Cfg ********* "
echo "${CONFIGURATION}"

clientID_value="$Auth0_ClientId"
domainAuth_value="$Auth0_Domain"

AUTH0_PATH=${PROJECT_DIR}/Prebuild/Auth0/Auth0.plist

/usr/libexec/PlistBuddy -c "Set :ClientId '$clientID_value'" $AUTH0_PATH
/usr/libexec/PlistBuddy -c "Set :Domain '$domainAuth_value'" $AUTH0_PATH
