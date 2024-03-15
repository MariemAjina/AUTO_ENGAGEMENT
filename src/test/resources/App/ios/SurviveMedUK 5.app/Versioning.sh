#!/bin/sh

#  Versioning.sh
#  ElsStudEng
#
#  Created by Ken 4B on 23/06/2020.
#  Copyright © 2020 Mobelite. All rights reserved.

echo $MARKETING_VERSION
/usr/libexec/PlistBuddy -c "Set CFBundleShortVersionString $MARKETING_VERSION" "${INFOPLIST_FILE}"
