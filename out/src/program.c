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

__MPyObj *var;



int main() {
	__mpy_builtins_setup();
	var = __mpy_obj_init_object();
	__mpy_obj_ref_inc(var);
	
	
	
	__mpy_obj_ref_dec(var);
	var = __mpy_obj_init_int(10);
	__mpy_obj_ref_inc(var);
	if (__mpy_boolean_raw(__mpy_call(__mpy_obj_get_attr(__mpy_call(__mpy_obj_get_attr(var, "__gt__"), __mpy_tuple_assign(0, __mpy_obj_init_int(9), __mpy_obj_init_tuple(1)), NULL), "__bool__"), __mpy_obj_init_tuple(0), NULL))) {
		__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_obj_init_str_static(""kleiner""), __mpy_obj_init_tuple(1)), NULL));
	}else if (__mpy_boolean_raw(__mpy_call(__mpy_obj_get_attr(__mpy_call(__mpy_obj_get_attr(var, "__gt__"), __mpy_tuple_assign(0, __mpy_obj_init_int(8), __mpy_obj_init_tuple(1)), NULL), "__bool__"), __mpy_obj_init_tuple(0), NULL))) {
		__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_obj_init_str_static(""kleinererer""), __mpy_obj_init_tuple(1)), NULL));
	}else {
		__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_obj_init_str_static("'klappt'"), __mpy_obj_init_tuple(1)), NULL));
	}
	__mpy_obj_ref_dec(var);
	
	
	
	__mpy_builtins_cleanup();
	return 0;
}
