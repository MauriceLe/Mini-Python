#include <stddef.h>

#include "assert.h"
#include "mpy_aliases.h"
#include "mpy_obj.h"
#include "builtins-setup.h"
#include "function-args.h"
#include "literals/tuple.h"
#include "literals/int.h"
#include "literals/boolean.h"
#include "literals/str.h"
#include "type-hierarchy/object.h"
#include "type-hierarchy/type.h"



__MPyObj *Animal;
__MPyObj* func_Animal___init__(__MPyObj *args, __MPyObj *kwargs) {
	assert(args != NULL && kwargs != NULL);
	
	__MPyGetArgsState argHelper = __mpy_args_init("__init__", args, kwargs, 1);
	__MPyObj *self = __mpy_args_get_positional(&argHelper, 0, "self");
	__mpy_args_finish(&argHelper);
	
	__MPyObj *retValue = NULL;
	
	__mpy_obj_ref_dec(__mpy_call(__mpy_super, __mpy_tuple_assign(0, self, __mpy_obj_init_tuple(1)), NULL));
	
	__mpy_obj_ref_dec(self);
	
	goto ret;
	ret:
	if (retValue == NULL) {
		retValue = __mpy_obj_init_object();
	}
	return __mpy_obj_return(retValue);
}
__MPyObj* func_Animal_wuff(__MPyObj *args, __MPyObj *kwargs) {
	assert(args != NULL && kwargs != NULL);
	
	__MPyGetArgsState argHelper = __mpy_args_init("wuff", args, kwargs, 1);
	__MPyObj *self = __mpy_args_get_positional(&argHelper, 0, "self");
	__mpy_args_finish(&argHelper);
	
	__MPyObj *retValue = NULL;
	
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_obj_init_str_static("'Wuff!'"), __mpy_obj_init_tuple(1)), NULL));
	
	__mpy_obj_ref_dec(self);
	
	goto ret;
	ret:
	if (retValue == NULL) {
		retValue = __mpy_obj_init_object();
	}
	return __mpy_obj_return(retValue);
}

int main() {
	__mpy_builtins_setup();
	
	
	Animal = __mpy_obj_init_type("Animal", __MPyType_Object);
	__mpy_obj_ref_inc(Animal);
	{
		__MPyObj *__init__;
		__init__ = __mpy_obj_init_func(&func_Animal___init__);
		__mpy_obj_ref_inc(__init__);
		__mpy_obj_set_attr(Animal, "__init__", __init__);
		__mpy_obj_ref_dec(__init__);
	}
	{
		__MPyObj *wuff;
		wuff = __mpy_obj_init_func(&func_Animal_wuff);
		__mpy_obj_ref_inc(wuff);
		__mpy_obj_set_attr(Animal, "wuff", wuff);
		__mpy_obj_ref_dec(wuff);
	}
	
	
	
	
	__mpy_obj_ref_dec(Animal);
	
	__mpy_builtins_cleanup();
	return 0;
}
