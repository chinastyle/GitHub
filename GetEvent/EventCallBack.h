#ifndef _EventCallBack_H
#define _EventCallBack_H

#include "InputEvent.h"

class EventCallBack {
public:
	//EventCallBack();
	EventCallBack();
	virtual ~EventCallBack();
	virtual bool callBack(InputEvent *mInputEvent);

	//InputEvent inputEvent;
};

#endif

