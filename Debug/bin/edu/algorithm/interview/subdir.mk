################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
../bin/edu/algorithm/interview/MultiplyExceptSelf.c \
../bin/edu/algorithm/interview/Q1_2.c 

OBJS += \
./bin/edu/algorithm/interview/MultiplyExceptSelf.o \
./bin/edu/algorithm/interview/Q1_2.o 

C_DEPS += \
./bin/edu/algorithm/interview/MultiplyExceptSelf.d \
./bin/edu/algorithm/interview/Q1_2.d 


# Each subdirectory must supply rules for building sources it contributes
bin/edu/algorithm/interview/%.o: ../bin/edu/algorithm/interview/%.c
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C Compiler'
	gcc -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


