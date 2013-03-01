################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
../src/edu/algorithm/interview/MultiplyExceptSelf.c \
../src/edu/algorithm/interview/Q1_2.c 

OBJS += \
./src/edu/algorithm/interview/MultiplyExceptSelf.o \
./src/edu/algorithm/interview/Q1_2.o 

C_DEPS += \
./src/edu/algorithm/interview/MultiplyExceptSelf.d \
./src/edu/algorithm/interview/Q1_2.d 


# Each subdirectory must supply rules for building sources it contributes
src/edu/algorithm/interview/%.o: ../src/edu/algorithm/interview/%.c
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C Compiler'
	gcc -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


