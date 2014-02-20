#include <avr/io.h>
#include <avr/interrupt.h>
#include <util/delay.h>

int main(void)
{
	DDRD &= ~(1<<2); //DDRDΪ����
	DDRC |= (1<<7); //DDRCΪ���,ʹ���������
	PORTC |= (1<<7); //ʹ����������
	MCUCR |= (1<< ISC01); //����INT0�½����ж�
	GICR |= (1 << INT0); //ʹ��INT0�ж�
	sei(); //ʹ��ȫ���ж�
	while(1);	
}

//INT0�жϷ������
ISR(INT0_vect)
{
	PORTC &= ~(1<<7); //��������
	_delay_ms(10); //��ʱ10����
	PORTC |= (1<<7); //����������
}
